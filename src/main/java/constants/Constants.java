package constants;

public final class Constants {

//      настройка для единственного модуля в проекте, когда RequestSpecification не нужна
//    public static class RunVariable {
//        public static final String server = Protocols.HTTP + Servers.JSONPLACEHOLDER;
//        public static final String path = Actions.COMMENTS;
//    }

    public static class Protocols {
        public static final String HTTP = "http://";
        public static final String HTTPS = "https://";
    }

    public static class Servers {
        public static final String SWAPI_SERVER = "swapi.dev/";
        public static final String JSONPLACEHOLDER = "jsonplaceholder.typicode.com/";
        public static final String PIPEDREAM = "eoj5p83fdbiqrlg.m.pipedream.net/";
        public static final String REQRES_SERVER = "reqres.in/";
        public static final String SUGGESTIONS_SERVER = "suggestions.dadata.ru/";
    }

    public static class Paths {
        public static final String SWAPI_PATH = "api/";
        public static final String REQRES_PATH = "api/";
        public static final String SUGGESTIONS_PATH = "suggestions/api/4_1/rs/suggest/";
    }

    public static class Actions {
        //swapi
        public static final String GET_FILMS = "films/";
        public static final String GET_PEOPLE = "people/";
        public static final String GET_PLANETS = "planets/";
        public static final String GET_SPECIES = "species/";
        public static final String GET_STARSHIPS = "starships/";
        public static final String GET_VEHICLES = "vehicles/";

        //jsonplaceholder
        public static final String POSTS = "posts/";
        public static final String COMMENTS = "comments/";

        //reqres
        public static final String GET_LIST_USERS = "users";
        public static final String GET_SINGLE_USER = "users/";

        //suggestions
        public static final String POST_FIO = "fio";
    }
}
