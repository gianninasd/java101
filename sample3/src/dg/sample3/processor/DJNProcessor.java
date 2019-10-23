package dg.sample3.processor;

import dg.sample3.PaymentRecord;

import java.util.logging.Logger;

/**
 * Implementation of the Processor for the DJN integration.
 */
public class DJNProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(DJNProcessor.class.getName());

    /**
     * Sends the payment request to the external provider
     */
    @Override
    public String send(PaymentRecord record) {
        logger.info("Sending to DJN: " + record.getMerchantRefNum());
        return null;
    }
}
