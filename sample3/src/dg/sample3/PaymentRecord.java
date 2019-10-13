package dg.sample3;

import java.util.StringTokenizer;

/**
 * Represents a payment record to process
 */
public class PaymentRecord {

  // external fields
  public static int totalCount;

  // internal fields
  private String merchantRefNum;
  private String amount;
  private String cardNumber;
  private String expiryMonth;
  private String expiryYear;
  private String firstName;
  private String lastName;
  private String email;
  private String postalCode;

  /**
   * Returns a string representation of this object
   */
  @Override
  public String toString() {
    return "PaymentRecord{" +
        "merchantRefNum='" + merchantRefNum + '\'' +
        ", amount='" + amount + '\'' +
        ", cardNumber='xxxx" + cardNumber.substring(cardNumber.length() - 4) + '\'' +
        ", email='" + email + '\'' +
        ", postalCode='" + postalCode + '\'' +
        '}';
  }

  /**
   * Parses the supplied record into the various fields of this object
   * @param record a comma separated string
   */
  public static PaymentRecord parse( String record ) {
    StringTokenizer tokenizer = new StringTokenizer(record, ",");
    int tokenPosition = 0;
    String token;
    PaymentRecord paymentRecord = new PaymentRecord();

    while (tokenizer.hasMoreTokens()) {
      token = tokenizer.nextToken();

      switch (tokenPosition) {
        case 0: paymentRecord.setMerchantRefNum(token); break;
        case 1: paymentRecord.setAmount(token); break;
        case 2: paymentRecord.setCardNumber(token); break;
        case 3: paymentRecord.setExpiryMonth(token); break;
        case 4: paymentRecord.setExpiryYear(token); break;
        case 5: paymentRecord.setFirstName(token); break;
        case 6: paymentRecord.setLastName(token); break;
        case 7: paymentRecord.setEmail(token); break;
        case 8: paymentRecord.setPostalCode(token); break;
      }

      tokenPosition++;
    }

    totalCount++;

    return paymentRecord;
  }

  public String getMerchantRefNum() {
    return merchantRefNum;
  }

  public void setMerchantRefNum(String merchantRefNum) {
    this.merchantRefNum = merchantRefNum;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getExpiryMonth() {
    return expiryMonth;
  }

  public void setExpiryMonth(String expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  public String getExpiryYear() {
    return expiryYear;
  }

  public void setExpiryYear(String expiryYear) {
    this.expiryYear = expiryYear;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
}
