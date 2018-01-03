
package grammarutils;

/**
 *
 * @author mason
 */
class PrivacyObject {
    private String privacySetting;

    public PrivacyObject(String setting) {
        privacySetting = setting;
    }

    public String toString(){
        return privacySetting;
    }
}
