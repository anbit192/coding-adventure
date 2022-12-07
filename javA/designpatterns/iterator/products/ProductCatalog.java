package designpatterns.iterator.products;

public class ProductCatalog implements Iterable {
    private String[] productCatalog;

    public ProductCatalog(String[] productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public Iterator getIterator() {
        return new ProductIterator();
    }

    public class ProductIterator implements Iterator {

        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            return currentPosition < productCatalog.length;
        }

        @Override
        public Object next() {
            if (currentPosition < productCatalog.length) {
                return productCatalog[currentPosition++];
            }

            return null;
        }
    }
}
