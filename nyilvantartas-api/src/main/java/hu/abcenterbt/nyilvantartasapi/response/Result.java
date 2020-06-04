package hu.abcenterbt.nyilvantartasapi.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Result<T> {

    public static final String STATUS_OK = "ok";
    public static final String STATUS_ERROR = "error";

    private Date timestamp;

    private String status;

    private String path;

    @Nullable
    private T data;

    private List<NyilvantartasError> errors = new ArrayList<>();

    private Result(final String status) {
        this.timestamp = new Date();
        this.status = status;
    }

    public Result(final T data) {
        this.timestamp = new Date();
        this.status = STATUS_OK;
        this.data = data;
    }

    public static Result ok() {
        return new Result(STATUS_OK);
    }

    public static Result ok(final Object data) {
        final Result res = new Result(STATUS_OK);
        res.data = data;
        return res;
    }

    public static Result error() {
        return new Result(STATUS_ERROR);
    }

    public static Result error(final NyilvantartasError error) {
        final Result result = new Result(STATUS_ERROR);
        result.errors = new ArrayList<>();
        result.errors.add(error);
        return result;
    }

    public static Result error(final List<NyilvantartasError> errors) {
        final Result result = new Result(STATUS_ERROR);
        result.errors = errors;
        return result;
    }

}
