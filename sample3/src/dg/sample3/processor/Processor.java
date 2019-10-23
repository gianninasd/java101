package dg.sample3.processor;

import dg.sample3.PaymentRecord;

/**
 * Definition of how to send a payment to a 3rd party processors.
 */
public interface Processor {

    /**
     * Sends a payment to an external processor.
     */
    public String send( PaymentRecord record );
}
