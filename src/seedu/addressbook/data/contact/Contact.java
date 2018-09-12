package seedu.addressbook.data.contact;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a contact of a person in addressbook
 * Guarantees: immutable; is valid as declared in {@link #isValid(String, String)}
 */
public class Contact {
    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate, String validation, String constraints) throws IllegalValueException{
        this.isPrivate = isPrivate;
        String trimmedEmail = value.trim();
        if (!isValid(trimmedEmail, validation)) {
            throw new IllegalValueException(constraints);
        }
        this.value = trimmedEmail;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValid(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
