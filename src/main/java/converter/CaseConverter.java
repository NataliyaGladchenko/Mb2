package converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CaseConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String someData) {
        return someData.toLowerCase();
    }

    @Override
    public String convertToEntityAttribute(String someData) {
        String[] a = someData.split("");
        a[0] = a[0].toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : a) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
