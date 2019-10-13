package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Invoice invoice = new Invoice("13/10/2019");

        Product laptop = new Product("Laptop");
        Product keyboard = new Product("Keyboard");
        Product usbC = new Product("USB-C to USB Adapter");

        Item itemLaptop = new Item(laptop, new BigDecimal(7000), 1, new BigDecimal(7000));
        Item itemKeyboard = new Item(keyboard, new BigDecimal(500), 1, new BigDecimal(500));
        Item itemUsbC = new Item(usbC, new BigDecimal(80), 3, new BigDecimal(240));

        itemLaptop.setInvoice(invoice);
        itemKeyboard.setInvoice(invoice);
        itemUsbC.setInvoice(invoice);

        List<Item> itemList = new ArrayList<>();
        itemList.add(itemLaptop);
        itemList.add(itemKeyboard);
        itemList.add(itemUsbC);

        invoice.setItems(itemList);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int size = invoice.getItems().size();

        //Then
        Assert.assertEquals(3, size);
        Assert.assertEquals(1, id);

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
