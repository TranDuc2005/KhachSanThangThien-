package DuAn2.Common;

/**
 * Simple application singleton that provides a default Encoder instance.
 * This is a convenience holder for non-Spring code that needs access to an Encoder.
 */
public class AppSingleton {
    private static final AppSingleton INSTANCE = new AppSingleton();
    private Encoder encoder;

    private AppSingleton() {
        // default to Logging decorator around Base64 encoder
        this.encoder = new LoggingEncoderDecorator(new Base64Encoder());
    }

    public static AppSingleton getInstance() {
        return INSTANCE;
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public void setEncoder(Encoder encoder) {
        if (encoder != null) {
            this.encoder = encoder;
        }
    }
}
