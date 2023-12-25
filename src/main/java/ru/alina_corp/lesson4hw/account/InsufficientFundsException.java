package ru.alina_corp.lesson4hw.account;


/**
 * Исключение, выбрасываемое при попытке снять средства со счета в большем объеме, чем имеется на счете.
 */
class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
