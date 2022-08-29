package hu.sonrisa.tocconverter.jsoninput;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class TOCItem {
    @JsonProperty("title")
    public String title;
    @JsonProperty("subtitles")
    public List<TOCItem> subTitles;

    public TOCItem(String title) {
        this.title = title;
    }

    public void addSubTitle(TOCItem item) {
        if (subTitles == null) {
            subTitles = new LinkedList<>();
        }
        subTitles.add(item);
    }
}
