package zzr.com.bantang.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */

public class TitleBannerEntity {

    /**
     * status : 1
     * msg : 成功
     * ts : 1486622027
     * data : {"topic":[{"id":"1105","type":"","type_id":"","title":"十款指甲油，给指甲也化个妆","pic":"http://bt.img.17gwx.com/topic/0/11/c1BeYQ/800x440","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"227056","praises":"42247","likes":"42227","comments":"1","items":"10","update_time":"1444050001","dateline":"1444050001","create_time_str":"09月21日","datestr":"10月05日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"3342","type":"","type_id":"","title":"指尖作画，要的就是精致美","pic":"http://bt.img.17gwx.com/topic/0/33/cVJaZg/800x440?v=7","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"81599","praises":"19446","likes":"19436","comments":"1","items":"10","update_time":"1464526801","dateline":"1464526801","create_time_str":"05月20日","datestr":"05月29日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"1830","type":"","type_id":"","title":"派对女王都爱用的最IN甲油色","pic":"http://bt.img.17gwx.com/topic/0/18/c1ldZA/800x440","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"99752","praises":"28500","likes":"28490","comments":"1","items":"10","update_time":"1452423601","dateline":"1452423601","create_time_str":"12月31日","datestr":"01月10日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"12320","type":"5","type_id":"","title":"最经典的秋冬色系指彩","pic":"http://bt.img.17gwx.com/topic/1/23/c1NdZlE/800x440","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"62215","praises":"15074","likes":"15074","comments":"","items":"","update_time":"1476158401","dateline":"1476158401","create_time_str":"10月09日","datestr":"10月11日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"949","type":"","type_id":"","title":"在家也能做美甲","pic":"http://bt.img.17gwx.com/topic/0/9/e1VX/800x440","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"143397","praises":"40064","likes":"40043","comments":"","items":"10","update_time":"1442372401","dateline":"1442372401","create_time_str":"09月07日","datestr":"09月16日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"4744","type":"","type_id":"","title":"好色之「涂」，要你好看","pic":"http://bt.img.17gwx.com/topic/0/47/dlZaYA/800x440","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"102163","praises":"14380","likes":"14368","comments":"19","items":"11","update_time":"1467622801","dateline":"1467622801","create_time_str":"06月23日","datestr":"07月04日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"2683","type":"","type_id":"","title":"女神必备装扮术\u2014\u2014美甲","pic":"http://bt.img.17gwx.com/topic/0/26/cFdWZw/800x440?v=4","is_recommend":true,"is_show_like":true,"islike":false,"ispraise":false,"views":"102991","praises":"33533","likes":"33515","comments":"","items":"10","update_time":"1461762001","dateline":"1461762001","create_time_str":"04月22日","datestr":"04月27日","pics":[],"user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}},{"id":"11595","type":"2","type_id":"1","title":"折腾指甲的二三事","pic":"","is_recommend":false,"is_show_like":true,"islike":false,"ispraise":false,"views":"2811","praises":"300","likes":"291","comments":"7","items":"6","update_time":"1474518578","dateline":"1474518578","create_time_str":"09月20日","datestr":"09月22日","pics":[{"url":"http://pic1.bantangapp.com/topic/201609/20/web_1474367896795_76802_66558/800x440"},{"url":"http://pic1.bantangapp.com/topic/201609/20/web_1474368073568_14048_14743/800x440"},{"url":"http://pic1.bantangapp.com/topic/201609/20/web_1474368426140_46792_55625/800x440"}],"user":{"user_id":"2197313","nickname":"不可逆的两只肉桂","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/002/19/73/13.jpg","is_official":0,"article_topic_count":"","post_count":""}}]}
     */

    private String status;
    private String msg;
    private int ts;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<TopicBean> topic;

        public List<TopicBean> getTopic() {
            return topic;
        }

        public void setTopic(List<TopicBean> topic) {
            this.topic = topic;
        }

        public static class TopicBean {
            /**
             * id : 1105
             * type :
             * type_id :
             * title : 十款指甲油，给指甲也化个妆
             * pic : http://bt.img.17gwx.com/topic/0/11/c1BeYQ/800x440
             * is_recommend : true
             * is_show_like : true
             * islike : false
             * ispraise : false
             * views : 227056
             * praises : 42247
             * likes : 42227
             * comments : 1
             * items : 10
             * update_time : 1444050001
             * dateline : 1444050001
             * create_time_str : 09月21日
             * datestr : 10月05日
             * pics : []
             * user : {"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}
             */

            private String id;
            private String type;
            private String type_id;
            private String title;
            private String pic;
            private boolean is_recommend;
            private boolean is_show_like;
            private boolean islike;
            private boolean ispraise;
            private String views;
            private String praises;
            private String likes;
            private String comments;
            private String items;
            private String update_time;
            private String dateline;
            private String create_time_str;
            private String datestr;
            private UserBean user;
            private List<?> pics;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public boolean isIs_recommend() {
                return is_recommend;
            }

            public void setIs_recommend(boolean is_recommend) {
                this.is_recommend = is_recommend;
            }

            public boolean isIs_show_like() {
                return is_show_like;
            }

            public void setIs_show_like(boolean is_show_like) {
                this.is_show_like = is_show_like;
            }

            public boolean isIslike() {
                return islike;
            }

            public void setIslike(boolean islike) {
                this.islike = islike;
            }

            public boolean isIspraise() {
                return ispraise;
            }

            public void setIspraise(boolean ispraise) {
                this.ispraise = ispraise;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getPraises() {
                return praises;
            }

            public void setPraises(String praises) {
                this.praises = praises;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getItems() {
                return items;
            }

            public void setItems(String items) {
                this.items = items;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getDateline() {
                return dateline;
            }

            public void setDateline(String dateline) {
                this.dateline = dateline;
            }

            public String getCreate_time_str() {
                return create_time_str;
            }

            public void setCreate_time_str(String create_time_str) {
                this.create_time_str = create_time_str;
            }

            public String getDatestr() {
                return datestr;
            }

            public void setDatestr(String datestr) {
                this.datestr = datestr;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public List<?> getPics() {
                return pics;
            }

            public void setPics(List<?> pics) {
                this.pics = pics;
            }

            public static class UserBean {
                /**
                 * user_id : 1
                 * nickname : 小糖君
                 * avatar : http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4
                 * is_official : 1
                 * article_topic_count :
                 * post_count :
                 */

                private String user_id;
                private String nickname;
                private String avatar;
                private int is_official;
                private String article_topic_count;
                private String post_count;

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public int getIs_official() {
                    return is_official;
                }

                public void setIs_official(int is_official) {
                    this.is_official = is_official;
                }

                public String getArticle_topic_count() {
                    return article_topic_count;
                }

                public void setArticle_topic_count(String article_topic_count) {
                    this.article_topic_count = article_topic_count;
                }

                public String getPost_count() {
                    return post_count;
                }

                public void setPost_count(String post_count) {
                    this.post_count = post_count;
                }
            }
        }
    }
}
