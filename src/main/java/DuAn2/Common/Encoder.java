package DuAn2.Common;

/**
 * Simple encoder/decoder interface để demo Decorator pattern.
 */
public interface Encoder {
    String encode(String input);
    String decode(String input);
}
