package cn.sanii.hello;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/4/17 09:38
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        byte a = 1;
        Byte b = 1;
        add(a);
        System.out.println(a);
        add(b);
        System.out.println(b);
    }

    public static void add(Byte d) {
//        ++d;
    }


    @Test
    public void test() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = sdf.parse("2018-05-09 18:32:43");
            System.out.println(System.currentTimeMillis() - date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Map getData(String data, String field) {

        Map json = (Map) JSON.parseObject(data);

        Map data1 = (Map) json.get("data");
        if (!data1.isEmpty()) {
            if (field.equals("orderInfo")) {
                return (Map) (data1).get("orderInfo");

            }
            JSONArray array = (JSONArray) (data1).get("passengerList");
            Map passengerList = (Map) array.get(0);
            if (array.isEmpty() || passengerList.isEmpty()) {
                return null;
            }
            if (field.equals("info")) {
                return (Map) passengerList.get("info");
            }

            JSONArray flightSegment = (JSONArray) passengerList.get("flightSegment");
            if (flightSegment.isEmpty()) {
                return null;
            }
            if (field.equals("flightSegment")) {
                return (Map) flightSegment.get(0);
            }
        }
        return null;
    }

    public static List<Map<String, String>> getId(String data) {
        Map map = JSON.parseObject(data);
        if (!map.isEmpty()) {
            Map data1 = (Map) map.get("data");
            if (data1 != null && !data1.isEmpty()) {
                JSONArray guests = (JSONArray) data1.get("guests");
                List<Map<String, String>> list = Lists.newArrayList();
                if (guests != null && !guests.isEmpty()) {
                    for (int x = 0; x < guests.size(); x++) {
                        Map pasenger = (Map) guests.get(x);
                        JSONArray arrayPAXS = (JSONArray) pasenger.get("paxs");
                        if (arrayPAXS != null && !arrayPAXS.isEmpty()) {
                            Map<String, String> paxsMap = Maps.newHashMap();
                            Map paxs = (Map) arrayPAXS.get(0);
                            String id = (String) paxs.get("id");
                            String ticketStatus = (String) paxs.get("ticketStatus");
                            paxsMap.put("id", id);
                            paxsMap.put("ticketStatus", ticketStatus);
                            list.add(paxsMap);
                        }
                    }
                    return list;
                }
            }
        }
        return null;
    }

    @Test
    public void test2() {
        String datajson = "{\"code\":200,\"data\":{\"orderInfo\":{\"orderCode\":\"0019124389\",\"orderState\":\"CANCELLED\",\"orderAmount\":\"580.00\",\"unpaidAmount\":\"580.00\",\"paidAmount\":\"0\",\"createOrderDate\":\"2018-04-25 10:46:19\",\"ticketedDate\":\"2018-04-25 11:06:19\",\"paymentDate\":\"2018-04-25 10:56:19\",\"contactName\":\"张明\",\"contactPhone\":\"171****3083\",\"contactEmail\":\"4265345440@qq.cn\",\"deductibleAmount\":\"0\",\"orderSource\":\"WESTAIR_WEB\"},\"passengerList\":[{\"info\":{\"name\":\"斯琴\",\"lastName\":\"斯\",\"firstName\":\"琴\",\"idType\":\"ID_CARD\",\"idNo\":\"150121199006025147\",\"passType\":\"ADT\",\"birthday\":\"1990-06-02\",\"mobile\":\"171****3083\",\"ticketType\":\"电子客票\",\"cardNo\":\"\",\"sysNo\":\"\"},\"flightSegment\":[{\"departureAirportLocationCode\":\"HET\",\"departureTime\":\"2018-05-04 16:35:00\",\"arrivalAirportLocationCode\":\"HFE\",\"arrivalTime\":\"2018-05-04 18:35:00\",\"airEquipType\":\"320\",\"marketingAirlineCode\":\"PN\",\"flightNumber\":\"6408\",\"shippingSpace\":\"N\",\"seatState\":\"\",\"fareFamilyCode\":\"ENJOY\",\"fareFamilyName\":\"超享惠\",\"ticketNo\":\"\",\"ticketState\":\"\",\"ticketAmount\":\"530\",\"payableAmount\":\"580.0\",\"totalAmount\":\"580.0\",\"tax\":[{\"code\":\"CN\",\"name\":\"民航发展基金\",\"amount\":\"50.00\"}],\"products\":[],\"segid\":\"\"}],\"productlist\":[]}],\"action\":[{\"code\":\"TRAVEL_EXTRAS_OPTION\",\"description\":\"增值服务\",\"enabled\":false},{\"code\":\"ONLINE_PAYMENT\",\"description\":\" 在线支付\",\"enabled\":false},{\"code\":\"CANCEL_ORDER\",\"description\":\" 取消订单\",\"enabled\":false},{\"code\":\"ERROR_REFUND\",\"description\":\"支付差错退款\",\"enabled\":false},{\"code\":\"REFUND_ORDER\",\"description\":\"退票申请\",\"enabled\":false},{\"code\":\"CHANGE_ITINERARY\",\"description\":\"更改行程\",\"enabled\":false},{\"code\":\"SELECT_SEATS\",\"description\":\" 选座\",\"enabled\":false}],\"pos\":\"WESTAIR_WEB\",\"islocked\":{\"status\":false,\"timeout\":0},\"insuranceOffers\":[],\"fareFamilies\":[{\"sequence\":1,\"code\":\"ENJOY\",\"name\":\"超享惠\",\"benefits\":[{\"code\":\"ENDORSEMENT_ALL\",\"name\":\"自愿签转\",\"text\":\"自愿签转:不允许签转.\"},{\"code\":\"CHANGE_FEE_ALL\",\"name\":\"变更服务费\",\"text\":\"变更服务费（每次）：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；        <br>航班计划离站时间24小时（含）外 - 10%；        <br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 20%；        <br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 30%；        <br>航班计划离站时间后 - 40%。\"},{\"code\":\"REFUND_FEE_ALL\",\"name\":\"退票费\",\"text\":\"退票费：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；        <br>航班计划离站时间24小时（含）外 - 20%；        <br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 30%；        <br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 40%；        <br>航班计划离站时间后 - 60%。\"},{\"code\":\"BAGGAGE_ALLOWANCE\",\"name\":\"免费托运行李\",\"text\":\"10KG免费托运行李(N舱无免费托运行李）.\"},{\"code\":\"CARRY_ON_BAGGAGE_ALLOWANCE\",\"name\":\"免费非托运行李\",\"text\":\"可免费携带一件7KG且体积不超过20cm x 30cm x 40cm的非托运行李进入客舱 .\"},{\"code\":\"MEAL_SERVICE\",\"name\":\"免费餐饮服务\",\"text\":\"免费餐饮服务：无.\"}]}]},\"traceid\":\"e454f8b31cde4200b36312cda2e307ae\"}\n" +
                " \t";
        String pa1 = "{\"code\":200,\"data\":{\"orderNo\":\"0019305989\",\"guests\":[{\"sequence\":\"1\",\"name\":\"文翔\",\"type\":\"ADULT\",\"phone\":\"17046020930\",\"docNumber\":\"513030199607286319\",\"docType\":\"ID_CARD\",\"paxs\":[{\"name\":\"文翔\",\"type\":\"ADULT\",\"id\":\"1_1\",\"org\":\"XIY\",\"dst\":\"CKG\",\"flightNo\":\"PN6222\",\"flightDate\":\"2018-05-19\",\"depTime\":\"23:50\",\"resStatus\":\"BOOKED\",\"ticketNo\":\"847-2476487877\",\"ticketStatus\":\"OPEN\",\"guestSeq\":\"\",\"cabin\":\"E\",\"refundRule\":\"退票费：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；       \\n<br>航班计划离站时间24小时（含）外 - 100%；       \\n<br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 100%；       \\n<br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 100%；       \\n<br>航班计划离站时间后 - 100%。\",\"interTicket\":\"0\",\"taxFees\":\"\",\"frontTicketStatus\":\"OPEN\"}],\"guestFirstName\":\"翔\",\"guestLastName\":\"文\"},{\"sequence\":\"2\",\"name\":\"魏榆汶\",\"type\":\"ADULT\",\"phone\":\"17046020930\",\"docNumber\":\"500105199704010618\",\"docType\":\"ID_CARD\",\"paxs\":[{\"name\":\"魏榆汶\",\"type\":\"ADULT\",\"id\":\"2_1\",\"org\":\"XIY\",\"dst\":\"CKG\",\"flightNo\":\"PN6222\",\"flightDate\":\"2018-05-19\",\"depTime\":\"23:50\",\"resStatus\":\"BOOKED\",\"ticketNo\":\"847-2476487876\",\"ticketStatus\":\"OPEN\",\"guestSeq\":\"\",\"cabin\":\"E\",\"refundRule\":\"退票费：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；       \\n<br>航班计划离站时间24小时（含）外 - 100%；       \\n<br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 100%；       \\n<br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 100%；       \\n<br>航班计划离站时间后 - 100%。\",\"interTicket\":\"0\",\"taxFees\":\"\",\"frontTicketStatus\":\"OPEN\"}],\"guestFirstName\":\"榆汶\",\"guestLastName\":\"魏\"}],\"fares\":[{\"org\":\"XIY\",\"dst\":\"CKG\",\"code\":\"BASIC\",\"description\":\"退票费：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；       \\n<br>航班计划离站时间24小时（含）外 - 100%；       \\n<br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 100%；       \\n<br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 100%；       \\n<br>航班计划离站时间后 - 100%。\"}],\"status\":\"TICKETED\"},\"traceid\":\"7e938a28223944a294be0945d7e2fd51\"}";
        String ps0="{\"code\":200,\"data\":{\"orderNo\":\"0019266826\",\"guests\":[{\"sequence\":\"1\",\"name\":\"黄春花\",\"type\":\"ADULT\",\"phone\":\"17191366248\",\"docNumber\":\"513723198305204488\",\"docType\":\"ID_CARD\",\"paxs\":[{\"name\":\"黄春花\",\"type\":\"ADULT\",\"id\":\"1_1\",\"org\":\"CKG\",\"dst\":\"SWA\",\"flightNo\":\"PN6305\",\"flightDate\":\"2018-05-17\",\"depTime\":\"05:55\",\"resStatus\":\"BOOKED\",\"ticketNo\":\"847-2476443072\",\"ticketStatus\":\"OPEN\",\"guestSeq\":\"\",\"cabin\":\"Z\",\"refundRule\":\"退票费：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；       \\n<br>航班计划离站时间24小时（含）外 - 100%；       \\n<br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 100%；       \\n<br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 100%；       \\n<br>航班计划离站时间后 - 100%。\",\"interTicket\":\"0\",\"taxFees\":\"\",\"frontTicketStatus\":\"OPEN\"}],\"guestFirstName\":\"春花\",\"guestLastName\":\"黄\"}],\"fares\":[{\"org\":\"CKG\",\"dst\":\"SWA\",\"code\":\"BASIC\",\"description\":\"退票费：如在飞行加APP购买可享航班计划离站时间14天外（含）退改手续费全免；       \\n<br>航班计划离站时间24小时（含）外 - 100%；       \\n<br>航班计划离站时间24小时（不含）内至航班计划离站时间4小时（含）外 - 100%；       \\n<br>航班计划离站时间4小时（不含）内至航班计划离站时间（含）外 - 100%；       \\n<br>航班计划离站时间后 - 100%。\"}],\"status\":\"TICKETED\"},\"traceid\":\"2efe9fe682bd4fb58005e7055ebaef33\"}\n";

//        Map info = getData(datajson, "info");
//        System.out.println(info.get("name"));
        List<Map<String, String>> list = getId(datajson);
        List<Map<String, String>> list0 = getId(ps0);
        List<Map<String, String>> list2 = getId(pa1);
        System.out.println(list);
        System.out.println(list0);
        System.out.println(list2);
    }
}
