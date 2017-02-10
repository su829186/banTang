package zzr.com.bantang.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */

public class MsgMoveEntity {


    /**
     * status : 1
     * msg : 成功
     * ts : 1486556880
     * data : {"list":[{"id":"432487407","title":"十八线小城市家里装修的这么文艺，花费居然还不多","type":"topic_detail","extend":"15962","browser_url":"","pic":"http://pic1.bantangapp.com/topic/201701/22/99989952_2792148_1.jpg","datestr":"8小时前","dateline":"1486526844","topic_type":"2"},{"id":"431470715","title":"新的一年，你的手机换新衣服了吗？","type":"topic_list","extend":"12339,1275,5430,3595,9788,1655,4717,1970","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/23/c1NdZ1g","datestr":"23小时前","dateline":"1486472982","topic_type":"5"},{"id":"430454401","title":"「一人居」男生卧室居然这么精致，你还有什么理由说懒？","type":"topic_detail","extend":"7612","browser_url":"","pic":"http://pic1.bantangapp.com/topic/201607/31/50505156_1270744_1.jpg","datestr":"02月07日","dateline":"1486441387","topic_type":"2"},{"id":"429438455","title":"60 款颜值和功能都满分的高人气文具","type":"topic_list","extend":"15826,13436,11909,5045,8078,4653","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/58/c1RWZlc","datestr":"02月06日","dateline":"1486386651","topic_type":""},{"id":"428185158","title":"10款暖炸了的新春礼物，真的会哭着说想要","type":"topic_detail","extend":"15808","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/58/c1RWZFk","datestr":"02月06日","dateline":"1486354008","topic_type":"5"},{"id":"427169930","title":"过年你可能错过的100件值得买的好东西，现在看还来得及","type":"topic_list","extend":"14929,15040,15372,15102,14892,15572,15976,15564,14212,7119,16035,14823","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/49/c1VXZlg","datestr":"02月05日","dateline":"1486300212","topic_type":"5"},{"id":"426155042","title":"假冒伪劣姨妈巾真的太黑心了，搞得我只敢买这些进口姨妈巾品牌了","type":"topic_detail","extend":"15237","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/52/c1RcZ1Y","datestr":"02月05日","dateline":"1486267613","topic_type":"5"},{"id":"425140524","title":"2017年即将登上荧幕的10本经典爱情小说","type":"topic_detail","extend":"15916","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/59/c1RXZVc","datestr":"02月04日","dateline":"1486213774","topic_type":"5"},{"id":"424126386","title":"10 款 连明星包里都会必带的平价好物","type":"topic_detail","extend":"16083","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/60/c1debFI","datestr":"02月04日","dateline":"1486181220","topic_type":""},{"id":"423350146","title":"洗一个舒服的澡，有哪些东西是必不可少的？","type":"topic_detail","extend":"15057","browser_url":"","pic":"http://bt.img.17gwx.com/topic/1/50/c1ReYVY","datestr":"02月03日","dateline":"1486127249","topic_type":"5"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 432487407
             * title : 十八线小城市家里装修的这么文艺，花费居然还不多
             * type : topic_detail
             * extend : 15962
             * browser_url :
             * pic : http://pic1.bantangapp.com/topic/201701/22/99989952_2792148_1.jpg
             * datestr : 8小时前
             * dateline : 1486526844
             * topic_type : 2
             */

            private String id;
            private String title;
            private String type;
            private String extend;
            private String browser_url;
            private String pic;
            private String datestr;
            private String dateline;
            private String topic_type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getExtend() {
                return extend;
            }

            public void setExtend(String extend) {
                this.extend = extend;
            }

            public String getBrowser_url() {
                return browser_url;
            }

            public void setBrowser_url(String browser_url) {
                this.browser_url = browser_url;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getDatestr() {
                return datestr;
            }

            public void setDatestr(String datestr) {
                this.datestr = datestr;
            }

            public String getDateline() {
                return dateline;
            }

            public void setDateline(String dateline) {
                this.dateline = dateline;
            }

            public String getTopic_type() {
                return topic_type;
            }

            public void setTopic_type(String topic_type) {
                this.topic_type = topic_type;
            }
        }
    }
}
