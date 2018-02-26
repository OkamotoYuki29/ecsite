package entity;

import annotation.KanaPattern;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 岡本　侑貴
 */

/** 商品エンティティ */
@Entity
@Table(name="FIT_PRODUCT")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** 商品名 */
	@Column(length = 30, nullable = false)
	private String name;
	
	/** 商品名かな */
	@Column(length = 50, nullable = false)
//	@KanaPattern(charaType = "かな")
	private String name_kana;
	
	/** 商品詳細 */
	@Lob
	private String text;
	
	/** 価格 */
	@Column(nullable = false)
	private Integer price;
	
	/** 商品カテゴリ */
	@ManyToOne
	private ProductCategory category;
	
	/** 商品画像 */
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] pic;
	
	/** ピックアップ情報 */
	@Enumerated(EnumType.STRING)
	private AppKind kind;
	
	/** 更新日 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	
	/** 変更追加日時の自動設定 */
	@PrePersist @PreUpdate
	private void now(){
		setUpdated(new Date());
	}
	
	/* ****** コンストラクタ *************/
	public Product(){
	}

	public Product(String name, String name_kana, String text, Integer price, ProductCategory category, byte[] pic, AppKind kind) {
		this.name = name;
		this.name_kana = name_kana;
		this.text = text;
		this.price = price;
		this.category = category;
		this.pic = pic;
		this.kind = kind;
	}
	
	
	
	/* ****** getter setter **************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_kana() {
		return name_kana;
	}

	public void setName_kana(String name_kana) {
		this.name_kana = name_kana;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public AppKind getKind() {
		return kind;
	}

	public void setKind(AppKind kind) {
		this.kind = kind;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 67 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Product other = (Product) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", kind=" + kind + '}';
	}
	
	
	
}
