package beans;

import entity.AppKind;
import entity.Product;
import entity.ProductCategory;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import util.BinFileUtil;
import util.Tracer;

@Interceptors(Tracer.class)
@Named
@RequestScoped
public class AdminProductBb extends AdminProductSuperBb implements Serializable{
	/* ******（productRegist）**************************************/
	public String registProduct(){
		System.out.println("aaaaaaaaaaaaa");
		create();
		System.out.println("aaaaaaaaaaaaa");
		name = name_kana = text = null;
		price = null;
		category = null;
		pic = null;
		kind = null;
		System.out.println("aaaaaaaaaaaaa");
		return "index";
	}
	
	public void create(){
		//Part→Stringパス
		String fpath = BinFileUtil.uploadImage(pic);
		//Stringパス→byte[]
		byte[] binaryData = BinFileUtil.getBinary(fpath);
		ProductCategory productCategory = (ProductCategory) productCateDb.find(category);
		Product product = new Product(name, name_kana, text, price, productCategory, binaryData, kind);
		productCategory.getPro().add(product);
		productDb.create(product);
	}
	
	public String productBundleRegist(){
		productBundle.init();
		return "index";
	};
	
}
