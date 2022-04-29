package challenges.datastructures.learning;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ListConstructors {

    /*
     * Arrays.asList()
     *      - returns an immutable list
     *      - size cannot be changed (added or subtracted)
     *      - contents are mutable.
     *      - can hold null values
     *      - can search for nulls (contains)
     *      - can be empty
     *      - can be used as view for array. Array changes reflect in list

     * List.of()
     *      - returns an immutable list
     *      - size cannot be changed (added or subtracted)
     *      - contents are immutable
     *      - can NOT have null values (throws NullPointerException)
     *      - can NOT search for nulls (throws NullPointerException)
     *      - can be empty
     *      - can be used as view for array. Array changes are NOT reflected in list

     * Collections.emptyList()
     *      - returns an immutable, empty list

     * Collections.unmodifiable(list)
     *      - returns an immutable view of 'list'
     *      - original list modifications (if possible) are reflected in the view
     */

    /**********
     * AsList *
     **********/
    @Test
    public void asList___CannotHaveItsSizeModified() {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = Arrays.asList(1, 2, 3);
            inner.add(4);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = Arrays.asList(1, 2, 3);
            inner.add(0,4);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = Arrays.asList(1, 2, 3);
            inner.remove(0);
        });
    }
    @Test
    public void asList___canHaveNullValue() {
        List<Integer> inner = Arrays.asList(1, 2, 3);
        inner.set(0, null);

        Arrays.asList(1, 2, null);
    }
    @Test
    public void asList___Content_IS_Mutable() {
        List<Integer> inner = Arrays.asList(1, 2, 3);
        assertAll(() -> {
            assertEquals(3, inner.size());
            assertEquals(1, inner.get(0));
            assertEquals(2, inner.get(1));
            assertEquals(3, inner.get(2));
        });

        inner.set(0, 4);
        assertAll(() -> {
            assertEquals(3, inner.size());
            assertEquals(4, inner.get(0));
            assertEquals(2, inner.get(1));
            assertEquals(3, inner.get(2));
        });
    }

    @Test
    public void asList___CanBeDeclaredWithZeroSize() {
        Arrays.asList();
    }

    @Test
    public void asList___canSearchForNull() {
        List<Integer> inner = Arrays.asList(1, null, 2);
        assertTrue(inner.contains(null));
    }

    @Test
    public void asList___ViewForArray() {
        Integer[] array = {1,2,3};
        List<Integer> inner = Arrays.asList(array);
        assertTrue(array.length == inner.size());

        array[0] = 4;
        assertEquals(4, inner.get(0));
    }

    /*************
     * List.Of() *
     ************/
    @Test
    public void ListOf___CannotHaveItsSizeModified() {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = List.of(1,2,3);
            inner.add(4);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = List.of(1,2,3);
            inner.add(0, 4);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = List.of(1, 2, 3);
            inner.remove(0);
        });
    }
    @Test
    public void ListOf___can_NOT_HaveNullValue() {
        assertThrows(NullPointerException.class, () -> {
            List<Integer> inner = List.of(1, 2, null);
        });
    }
    @Test
    public void ListOf___Content_IS_NOT_Mutable() {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> inner = List.of(1, 2, 3);
            inner.set(0, 4);
        });
    }

    @Test
    public void ListOf___CanBeDeclaredWithZeroSize() {
        List.of();
    }

    @Test
    public void ListOf___canSearchForNull() {
        assertThrows(NullPointerException.class, () -> {
            List<Integer> inner = List.of(1, 2);
            inner.contains(null);
        });
    }

    @Test
    public void ListOf___ViewForArray() {
        Integer[] array = {1,2,3};
        List<Integer> inner = List.of(array);
        assertTrue(array.length == inner.size());

        array[0] = 4;
        assertEquals(1, inner.get(0));
    }

    /***************************
     * Collections.emptyList() *
     **************************/
    @Test
    public void CollectionsEmptyList___isImmutable() {
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> emptyList = Collections.emptyList();
            emptyList.add(0);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> emptyList = Collections.emptyList();
            emptyList.add(0,0);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            List<Integer> emptyList = Collections.emptyList();
            emptyList.remove(0);
        });
    }


    /**********************************
     * Collections.unmodifiableList() *
     *********************************/
    @Test
    public void CollectionsUnmodifiable___providesAnUnmodifiableViewThatUpdatesToReflectInnerChanges() {
        List<Integer> inner = new ArrayList<>();
        inner.add(0);
        inner.add(0);
        inner.add(0);
        List<Integer> outer = Collections.unmodifiableList(inner);

        /* Additions/Subtractions are reflected in 'outer' */
        assertTrue(inner.size() == outer.size());
        inner.add(0);
        assertTrue(inner.size() == outer.size());
        inner.remove(0);
        assertTrue(inner.size() == outer.size());

        /* View cannot be modified */
        assertThrows(UnsupportedOperationException.class, () -> outer.add(0));
        assertThrows(UnsupportedOperationException.class, () -> outer.add(0,0));
        assertThrows(UnsupportedOperationException.class, () -> outer.set(0,0));
        assertThrows(UnsupportedOperationException.class, () -> outer.remove(0));
    }

}

