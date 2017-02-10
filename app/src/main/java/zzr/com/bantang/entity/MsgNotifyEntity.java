package zzr.com.bantang.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */

public class MsgNotifyEntity {

    /**
     * status : 1
     * msg : 成功
     * ts : 1486553892
     * data : {"list":[],"message":[{"unread":"0","message_content":{"id":"0","is_default":1,"content":"Hello！我是小糖君，欢迎你的到来。如果遇到任何问题你都可以在这里给我留言，不一定及时，但每条必回^_^","datestr":"刚刚","user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}}}]}
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
        private List<?> list;
        private List<MessageBean> message;

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public List<MessageBean> getMessage() {
            return message;
        }

        public void setMessage(List<MessageBean> message) {
            this.message = message;
        }

        public static class MessageBean {
            /**
             * unread : 0
             * message_content : {"id":"0","is_default":1,"content":"Hello！我是小糖君，欢迎你的到来。如果遇到任何问题你都可以在这里给我留言，不一定及时，但每条必回^_^","datestr":"刚刚","user":{"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}}
             */

            private String unread;
            private MessageContentBean message_content;

            public String getUnread() {
                return unread;
            }

            public void setUnread(String unread) {
                this.unread = unread;
            }

            public MessageContentBean getMessage_content() {
                return message_content;
            }

            public void setMessage_content(MessageContentBean message_content) {
                this.message_content = message_content;
            }

            public static class MessageContentBean {
                /**
                 * id : 0
                 * is_default : 1
                 * content : Hello！我是小糖君，欢迎你的到来。如果遇到任何问题你都可以在这里给我留言，不一定及时，但每条必回^_^
                 * datestr : 刚刚
                 * user : {"user_id":"1","nickname":"小糖君","avatar":"http://7te7t9.com2.z0.glb.qiniucdn.com/000/00/00/01.jpg?v=4","is_official":1,"article_topic_count":"","post_count":""}
                 */

                private String id;
                private int is_default;
                private String content;
                private String datestr;
                private UserBean user;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getIs_default() {
                    return is_default;
                }

                public void setIs_default(int is_default) {
                    this.is_default = is_default;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
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
}
