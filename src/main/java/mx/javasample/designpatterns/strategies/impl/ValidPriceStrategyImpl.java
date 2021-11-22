package mx.javasample.designpatterns.strategies.impl;

import mx.javasample.designpatterns.model.Price;
import mx.javasample.designpatterns.strategies.ValidPriceStrategy;
import org.springframework.util.Assert;

import java.time.LocalDate;

public class ValidPriceStrategyImpl implements ValidPriceStrategy {

    /**
     * @see ValidPriceStrategy#isPriceValid(Price).
     */
    @Override
    public boolean isPriceValid(final Price price) {
        Assert.notNull(price, "Price should not be null");

        final var today = LocalDate.now();

        final var isStartValid = price.getValidFrom() != null && price.getValidFrom().isBefore(today);
        final var isEndValid = price.getValidThrough() != null && price.getValidThrough().isAfter(today);

        return isStartValid && isEndValid;
    }
}
