package com.app.valeron.Model;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class ProductXMLParser {

    public static final String TAG = ProductXMLParser.class.getSimpleName();

    public List<Product> parseXMLData(String xml) {
        List<Product> products = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new InputSource(new StringReader(xml)), new XMLHandler(products));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, products.toString());
        return products;
    }

    private class XMLHandler extends DefaultHandler {
        private static final String productt = "URUNLER";
        private static final String productId = "ID";
        private static final String productSKU = "MALZEME";
        private static final String productName = "URUN_ADI";
        private static final String productColor = "RENK";
        private static final String productSizeDetail = "EBAT_DETAY";
        private static final String productPrice = "KDV_DAHIL";
        private static final String productImgUrl = "FULL_PATH_IMAGE3";

        private boolean isProductSKU = false;
        private boolean isProductId = false;
        private boolean isProductName = false;
        private boolean isProductColor = false;
        private boolean isProductSizeDetail = false;
        private boolean isProductPrice = false;
        private boolean isProductImgUrl = false;

        private final List<Product> products;

        private Product product;

        public XMLHandler(List<Product> products) {
            this.products = products;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(productt)) {
                product = new Product();
            } else if (qName.equals(productSKU)) {
                isProductSKU = true;
            }else if (qName.equals(productId)) {
                isProductId = true;
            } else if (qName.equals(productName)) {
                isProductName = true;
            }else if (qName.equals(productColor)) {
                isProductColor = true;
            }else if (qName.equals(productSizeDetail)) {
                isProductSizeDetail = true;
            } else if (qName.equals(productPrice)) {
                isProductPrice = true;
            } else if (qName.equals(productImgUrl)) {
                isProductImgUrl = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isProductName) {
                product.setProductName(new String(ch, start, length));
                isProductName = false;
            } else if (isProductColor) {
                product.setProductColor(new String(ch, start, length));
                isProductColor = false;
            }else if (isProductSKU) {
                product.setProductSKU(new String(ch, start, length));
                isProductSKU = false;
            }else if (isProductId) {
                product.setProductId(new String(ch, start, length));
                isProductId = false;
            }else if (isProductSizeDetail) {
                product.setProductSizeDetail(new String(ch, start, length));
                isProductSizeDetail = false;
            } else if (isProductImgUrl) {
                product.setProductImgUrl(new String(ch, start, length));
                Log.d(product.getProductImgUrl(),"URL");
                isProductImgUrl = false;
            } else if (isProductPrice) {
                try {
                    product.setProductPrice(Double.parseDouble(new String(ch, start, length)));
                } catch (Exception e) {
                    product.setProductPrice(0.0d);
                }
                isProductPrice = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(productt)) {
                products.add(product);
            }
        }
    }
}
