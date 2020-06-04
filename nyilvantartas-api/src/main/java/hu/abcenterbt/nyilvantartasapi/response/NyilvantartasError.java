package hu.abcenterbt.nyilvantartasapi.response;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class NyilvantartasError {

    public static final String PREFIX_HTTP = "HTTP-";
    public static final String PREFIX_NYILVANTARTASTICKET = "CT-";

    public static final String EC_INTERNAL_ERROR = PREFIX_NYILVANTARTASTICKET + "101";
    public static final String EC_ENTITY_NOT_FOUND = PREFIX_NYILVANTARTASTICKET + "201";

    private static final String TITLE_1XX = "Alkalmazás hiba";
    private static final String TITLE_2XX = "Adatbázis hiba";

    private static final Map<String, String> TITLES = new HashMap<>();
    private static final Map<String, String> MESSAGE_TEMPLATES = new HashMap<>();

    private String errorCode;
    private String errorTitle;
    private String errorMessage;

    public NyilvantartasError(final String errorCode, final String errorTitle, final String errorMessage) {
        this.errorCode = errorCode;
        this.errorTitle = errorTitle;
        this.errorMessage = errorMessage;
    }

    public NyilvantartasError(final String errorCode, final Object param) {
        this.errorCode = errorCode;
        this.errorTitle = TITLES.get(errorCode);
        this.errorMessage = format(errorCode, new Object[]{param});
    }

    public NyilvantartasError(final String errorCode, final Object[] params) {
        this.errorCode = errorCode;
        this.errorTitle = TITLES.get(errorCode);
        this.errorMessage = format(errorCode, params);
    }

    static {
        TITLES.put(EC_INTERNAL_ERROR, TITLE_1XX);
        TITLES.put(EC_ENTITY_NOT_FOUND, TITLE_2XX);

        MESSAGE_TEMPLATES.put(EC_INTERNAL_ERROR, "{0}");
        MESSAGE_TEMPLATES.put(EC_ENTITY_NOT_FOUND, "Nem található {0} entitás a megadott azonosítóval: {1}");
    }

    public static NyilvantartasError ct101(final String errorMessage) {
        return new NyilvantartasError(EC_INTERNAL_ERROR, errorMessage);
    }

    public static NyilvantartasError ct201(final String entityName, final Long entityId) {
        return new NyilvantartasError(EC_ENTITY_NOT_FOUND, new Object[]{entityName, entityId});
    }

    public static NyilvantartasError ct201(final String entityName, final String idType, final String idValue) {
        return new NyilvantartasError(EC_ENTITY_NOT_FOUND, new Object[]{entityName, idType + "=" + idValue});
    }

    public static NyilvantartasError newCampusTicketError(final String code, final Object[] params) {
        return new NyilvantartasError(code, params);
    }

    public static NyilvantartasError newHttpError(final HttpStatus httpStatus, final String errorTitle, final String errorMessage) {
        return new NyilvantartasError(PREFIX_HTTP + httpStatus.value(), errorTitle, errorMessage);
    }

    private static String format(final String code, final Object[] params) {
        final String template = MESSAGE_TEMPLATES.get(code);
        return MessageFormat.format(template, params);
    }

}

