public class K {

    public static final String COMMENTS_LOCATION = "https://jsonplaceholder.typicode.com/comments";

    public static String findID(int a) {
        return COMMENTS_LOCATION + "?postId=" + a;
    }

    public static String createComments(String name, String email, String body) {

        return "{\n\"name\":\"" + name + "\",\n\"email\":\"" + email + "\",\n\"body\":\"" + body + "\"\n},";
    }


}
