
package grammarutils;

import java.util.Date;

/**
 * @author mason
 */
public class Document {
    private String title = "";
    private String description = "";
    private String keywords = "";
    private Date created = new Date();
    private Date updated = new Date();
    private Boolean readOnly = true;
    private PrivacyObject privacy = new PrivacyObject("");

    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("title: ").append(title).append("\n");
        builder.append("description: ").append(description).append("\n");
        builder.append("keywords: ").append(keywords).append("\n");
        builder.append("created: ").append(created).append("\n");
        builder.append("updated: ").append(updated).append("\n");
        builder.append("readOnly: ").append(readOnly).append("\n");
        builder.append("privacy: ").append(privacy.toString()).append("\n");

        return builder.toString();
    }
}
