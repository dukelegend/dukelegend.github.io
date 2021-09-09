package new_entity;


import entity.BigOrder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PayContext {

    private BigOrder orders;

    private List<NBook_SalesBook> bookInfos;

    private HttpServletResponse response;

    public List<NBook_SalesBook> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(List<NBook_SalesBook> bookInfos) {
        this.bookInfos = bookInfos;
    }

    public BigOrder getOrders() {
        return orders;
    }

    public void setOrders(BigOrder orders) {
        this.orders = orders;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
