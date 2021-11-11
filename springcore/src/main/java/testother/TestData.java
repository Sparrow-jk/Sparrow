package testother;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author chansiwan
 * @since 2021-05-11 16:44
 */
@Data
@AllArgsConstructor
public class TestData {

    private List<String> text1;
    private String text2;
    private String text3;
}
