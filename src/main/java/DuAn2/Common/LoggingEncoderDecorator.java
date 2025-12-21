package DuAn2.Common;

/**
 * Decorator: bọc một Encoder khác, log trước/sau khi gọi.
 */
public class LoggingEncoderDecorator implements Encoder {

    private final Encoder delegate;

    public LoggingEncoderDecorator(Encoder delegate) {
        this.delegate = delegate;
    }

    @Override
    public String encode(String input) {
        System.out.println("[LoggingEncoderDecorator] encode() input length=" + (input == null ? "null" : input.length()));
        String out = delegate.encode(input);
        System.out.println("[LoggingEncoderDecorator] encode() output length=" + (out == null ? "null" : out.length()));
        return out;
    }

    @Override
    public String decode(String input) {
        System.out.println("[LoggingEncoderDecorator] decode() input length=" + (input == null ? "null" : input.length()));
        String out = delegate.decode(input);
        System.out.println("[LoggingEncoderDecorator] decode() output length=" + (out == null ? "null" : out.length()));
        return out;
    }
}
