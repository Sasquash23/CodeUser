package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testToString() {
        //given
        Library library = new Library("Library number 1:");
        IntStream.iterate(1, n -> n + 1)
                .limit(7)
                .forEach(n -> library.getBooks().add(new Book("Tom "+n, "Lackberg Camilla",
                        LocalDate.of(2003+n, 04+n,01+n))));
        //when
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library number 2:");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library number 3:");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        clonedLibrary.getBooks().removeAll(clonedLibrary.getBooks());

        //then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(0, library.getBooks().size());
        Assert.assertEquals(0, clonedLibrary.getBooks().size());
        Assert.assertEquals(7, deepClonedLibrary.getBooks().size());
    }
}
