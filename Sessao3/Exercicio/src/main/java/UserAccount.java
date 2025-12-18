public class UserAccount {
    private String email;
    private String userName;
    private UserAccount[] followers;
    private  UserAccount[] following;
    private Post[] posts;
    private Post[] timeline;
    private int quantidadePosts;
    private int quantidadeTimeline;
    private int quantidadeFollowers;
    private int quantidadeFollowing;

    public UserAccount(String email, String userName) {
        this.email = email;
        this.userName = userName;
        this.followers = new UserAccount[50];
        this.following = new UserAccount[50];
        this.posts = new Post[50];
        this.timeline = new Post[10];
        this.quantidadePosts = 0;
        this.quantidadeTimeline = 0;
        this.quantidadeFollowers = 0;
        this.quantidadeFollowing = 0;
    }


    public void publish(String quote){
        Post novoPost = new Post(this, quote);
        posts[quantidadePosts] = novoPost;
        quantidadePosts++;

        timeline[quantidadeTimeline] = novoPost;
        quantidadeTimeline++;

        for(int i = 0; i < quantidadeFollowers; i++){
            followers[i].updateTimeline(novoPost);
        }
    }


    public boolean delete(int postIndex){
        if(postIndex < 0 || postIndex > quantidadePosts) return false;

        for(int i = postIndex; i < quantidadePosts - 1; i++){
            posts[i] = posts[i+1];
        }

        posts[quantidadePosts - 1] = null;
        quantidadePosts--;
        return true;
    }


    public String showTimeline(){
        StringBuilder linha = new StringBuilder();
        for(int i = 0; i < quantidadeTimeline; i++){
            linha.append(",").append(timeline[i].show()).append("\n");
        }

        return linha.toString();
    }




    public String showMyPosts(){
        StringBuilder myPosts = new StringBuilder();
        for(int i = 0; i < quantidadePosts; i++){
            myPosts.append(",").append(posts[i].show()).append("\n");
        }

        return  myPosts.toString();

    }


    public String showMyFriends(){
        StringBuilder myFriends = new StringBuilder("Meus seguidores: \n");
        for(int i = 0; i < quantidadeFollowers; i++){
            myFriends.append("- ").append(followers[i].getUserName()).append("\n");
        }

        return myFriends.toString();
    }


    public void clapPost(int postIndex){
        if(postIndex >= 0 && postIndex <= quantidadeTimeline){
            timeline[postIndex].clap();
        }
        else{
            System.out.println("Post não encontrado na timeline");
        }

    }

    public void booPost(int postIndex){
        if(postIndex >= 0 && postIndex <= quantidadeTimeline){
            timeline[postIndex].boo();
        }
        else{
            System.out.println("Post não encontrado na timeline");
        }


    }

    public void updateTimeline(Post newPost ){

    }

    public void acceptFollower(UserAccount newFollower){
        if(newFollower != null){
            followers[quantidadeFollowers] = newFollower;
            quantidadeFollowers++;
        }
    }


    public void blockFollower(UserAccount newFollower){
        if(newFollower != null){
            for(int i = 0; i < quantidadeFollowers; i++){
                if(followers[i] == newFollower){
                    for (int j = i; j < quantidadeFollowers-1 ; j++){
                        followers[j] = followers[j+1];
                    }
                    followers[quantidadeFollowers-1] = null;
                    quantidadeFollowers--;
                }
            }
        }
    }


    public String getUserName(){
        return this.userName;
    }

}
