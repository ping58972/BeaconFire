//class User{
//    public int id;
//    public int age;
//
//    public User(int id, int age){
//        this.id = id;
//        this.age = age;
//    }
//    public static void main(String[] args){
//        List<User> list = Arrays.asList(
//                new User(1, 30),
//                new User(2, 30),
//                new User(3, 28)
//        );
//        // sort users by age, if two users have the same age, then sort by id. All in ascending order
//        Collections.sort(list, (u1,u2)->{
//            if((u1.age == u2.age)>0){
//            return u1.id - u2.id;
//                    }
//            return u1.age - u2.age;
//                }
//        );
//    }
//}
//
