package tg.Ipnet.efunerailles.Utils;


import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private boolean success;
    private String message;
    private T data;
    
    
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}