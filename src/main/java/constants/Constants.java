package constants;

public class Constants {

//      настройка для единственного модуля в проекте, когда RequestSpecification не нужна
//    public static class RunVariable {
//        public static String server = Protocols.HTTP + Servers.JSONPLACEHOLDER;
//        public static String path = Actions.COMMENTS;
//    }

    public static class Protocols {
        public static String HTTP = "http://";
        public static String HTTPS = "https://";
    }

    public static class Servers {
        public static String SWAPI_SERVER = "swapi.dev/";
        public static String JSONPLACEHOLDER = "jsonplaceholder.typicode.com/";
        public static String REQRES_SERVER = "reqres.in/";
        public static String SUGGESTIONS_SERVER = "suggestions.dadata.ru/";
    }

    public static class Paths {
        public static String SWAPI_PATH = "api/";
        public static String REQRES_PATH = "api/";
        public static String SUGGESTIONS_PATH = "suggestions/api/4_1/rs/suggest/";
    }

    public static class Actions {
        //swapi
        public static String GET_FILMS = "films/";
        public static String GET_PEOPLE = "people/";
        public static String GET_PLANETS = "planets/";
        public static String GET_SPECIES = "species/";
        public static String GET_STARSHIPS = "starships/";
        public static String GET_VEHICLES = "vehicles/";

        //jsonplaceholder
        public static String POSTS = "posts/";
        public static String COMMENTS = "comments/";

        //reqres
        public static String GET_LIST_USERS = "users?page=";
        public static String GET_SINGLE_USER = "users/";

        //suggestions
        public static String POST_FIO = "fio";
    }
}
