package beans;

import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class CustomerBb extends CustomerSuperBb implements Serializable{
	@Inject
	Conversation conv;

	/* *****(ユーザー登録)******************/
	/* content-1 */
	public String goto1_forRegist(){
		if(conv.isTransient()) conv.begin();
		editable = true;
		return "/customer/info1.xhtml?faces-redirect=true";
	}
	/* content-2 */
	public String goto2(){

		//メール処理
		return "/customer/info2.xhtml?faces-redirect=true";
	}

	/* *****(ユーザー情報表示・変更)******************/
	/* content-1 */
	public String goto1_forDispEdit(){
		if(conv.isTransient()) conv.begin();
		editable = false;
		displayable = true;
		return "/customer/info1.xhtml?faces-redirect=true";
	}
	/* end */
	public String end_forDispEdit(){
		conv.end();
		// 変更DB処理
		return null;
	}
}
