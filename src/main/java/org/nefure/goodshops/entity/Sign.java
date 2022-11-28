package org.nefure.goodshops.entity;
import java.math.BigInteger;
import java.sql.Date;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 *
 * @author nefure
 * @since 2022/11/26 16:13
 */
@Data
@Accessors(chain = true)
public class Sign implements Serializable {

    @Serial
    private static final long serialVersionUID = 2136536386975379456L;
    private BigInteger id;
    private BigInteger userId;
    private Date year;
    private Integer month;
    private Date date;
    private Integer isBackup;
}