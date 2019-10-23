package dg.sample3.processor;

import dg.sample3.PaymentRecord;

import java.util.logging.Logger;

/**
 * Implementation of the Processor for the TSYS integration.
 */
public class TSYSProcessor extends AbstractProcessor {

    private static Logger logger = Logger.getLogger(TSYSProcessor.class.getName());

    /**
     * Sends the payment request to the external provider
     */
    @Override
    public String send(PaymentRecord record) {
        logger.info("Sending to TSYS: " + record.getMerchantRefNum());
        return null;
    }
}
