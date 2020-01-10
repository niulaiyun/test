package thread;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;
    private String title;
    private Integer preantId;
    private String url;
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPreantId() {
        return preantId;
    }

    public void setPreantId(Integer preantId) {
        this.preantId = preantId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    private String field;
    private List<Menu> children=new ArrayList<>();

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", preantId=" + preantId +
                ", field='" + field + '\'' +
                ", children=" + children +
                '}';
    }
}
