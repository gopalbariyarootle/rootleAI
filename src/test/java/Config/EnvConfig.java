package Config;

import io.github.cdimascio.dotenv.Dotenv;

public final class EnvConfig {

    // Load .env only for local; Jenkins will ignore this
    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    // Private constructor to prevent object creation
    private EnvConfig() {}

    /**
     * Priority:
     * 1. Jenkins environment variables
     * 2. Local .env file
     */
    private static String get(String key) {
        String value = System.getenv(key); // Jenkins
        if (value != null && !value.isBlank()) {
            return value;
        }

        value = dotenv.get(key); // Local
        if (value != null && !value.isBlank()) {
            return value;
        }

        throw new RuntimeException("Environment variable missing: " + key);
    }

    // ---------- Public getters ----------

    public static String getWebUrl() {
        return get("Admin_URL");
    }

    public static String getDirectorUser() {
        return get("Admin_User");
    }

    public static String getDirectorPass() {
        return get("Admin_Pass");
    }

    public static String getAppUrl() {
        return get("App_URL");
    }

    public static String getAppEmail() {
        return get("App_User");
    }

    public static String getAppPass() {
        return get("App_Pass");
    }

    public static String getAppOrganization() {
        return get("ORG_Name");
    }

    public static String getForgotUser() {
        return get("FORGOT_USER");
    }
    public static String getForgotPass() {
        return get("FORGOT_PASS");
    }

    public static boolean isCI() {
        return "ci".equalsIgnoreCase(getOptional("ENV", "local"));
    }

    // Optional helper (no failure)
    private static String getOptional(String key, String defaultValue) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            value = dotenv.get(key);
        }
        return (value == null || value.isBlank()) ? defaultValue : value;
    }
}
