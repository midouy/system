package org.system.web.controller.mvcExample;

import bit.wym.commons.date.DateUtils;
import bit.wym.commons.util.DataShower;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.system.common.response.ResponseUtil;
import org.system.web.controller.mvcExample.beansForExample.Person;
import org.system.web.controller.mvcExample.beansForExample.PersonList;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyanming on 2015/8/18.
 */
@Controller
@RequestMapping("main")
public class Main
{
    @RequestMapping("mainPage")
    public String showMainPage()
    {
        return "main/test";
    }

    @RequestMapping("test")
    public String showTest()
    {
        return "test";
    }

	@RequestMapping("/{index}/test")
	//在路径匹配中加入参数, 这种方式可以让一套后台代码匹配多套前台页面
	public String Test(@PathVariable String index){

		System.out.println("index = " + index);

		return "test";
	}


	/**
	 *正常的数据传递
	 */
	@RequestMapping("/test/normal")
	@ResponseBody
	public Map<String, Object> TestNormal(HttpServletRequest request,  //@RequestParam 可以手动注入传递参数,
										  @RequestParam(value = "name", required = true) String name, int age){
		System.out.println(request.toString());
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return ResponseUtil.successResult("testNormal run");
	}


	/**
	 * 通过JSON字符串的形式传递一个数组
	 */
	@RequestMapping(value = "test/array")
	@ResponseBody
	public void TestArray(@RequestBody List<Person> users, HttpServletRequest request)
	{
		System.out.println("testArray");
		DataShower.show(users);
	}

	/**
	 * 封装成一个对象
	 */
	@RequestMapping(value = "testBean")
	@ResponseBody
	public Map<String, Object> testBean(HttpServletRequest request, Model model, @ModelAttribute Person person)
	{
		try
		{
			System.out.println("REQUEST Getting : testBean");
			System.out.println(person);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ResponseUtil.failResult(" Request failed : " + "testBean");
	}

	/**
	 * 封装成一个复杂对象( 传递JSON对象 )
	 * 可以传递多个参数
	 *
	 */
	public Map<String, Object> complex(PersonList users , String anotherPara)
	{
		try
		{
			System.out.println("REQUEST Getting [ "+ DateUtils.getCurrentFormatDateTime()+" ] : >>> complex <<< ");
			System.out.println(users);
			System.out.println("anotherPara : "+ anotherPara);
			System.out.println("name : " + users.getTitle());
			System.out.println("age : " + users.getAge());
			DataShower.show(users.getPersons());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ResponseUtil.failResult(" Request failed : " + "complex");
	}


	/**
	 * 封装成一个复杂对象( 传递JSON字符串 )
	 */
	@RequestMapping(value = "complexString")
	@ResponseBody
	public Map<String, Object> complexString(@RequestBody PersonList users)
	{
		try
		{
			System.out.println("REQUEST Getting [ " + DateUtils.getCurrentFormatDateTime() + " ] : >>> complexString <<<");
			System.out.println(users);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ResponseUtil.failResult(" Request failed : " + "complexString");
	}
}
