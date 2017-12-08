package com.hzz.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hzz.entity.SmbmsProvider;
import com.hzz.entity.SmbmsUser;
import com.hzz.service.SmbmsProviderService;

@Controller
@RequestMapping("jsp")
public class SmbmsProviderController {
	@Autowired
	private SmbmsProviderService ps;


	@RequestMapping(value="provider.do",method={RequestMethod.POST,RequestMethod.GET})
	public String providerList(String queryProCode,String queryProName,@RequestParam(defaultValue="1")Integer pageIndex,Map<String, Object> model){
		Integer pageSize=5;
		List<SmbmsProvider> providerList = ps.getSmbmsProviderList(queryProCode, queryProName, pageIndex, pageSize);
		int totalCount = ps.getCount(queryProCode, queryProName);
		int totalPageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		model.put("providerList", providerList);
		//��ǰҳ
		model.put("currentPageNo", pageIndex);
		//��ҳ��
		model.put("totalPageCount", totalPageCount);
		//������
		model.put("totalCount", totalCount);

		model.put("queryProCode", queryProCode);
		model.put("queryProName", queryProName);

		return "jsp/providerlist";
	}

	@RequestMapping(value="provideradd.do",method=RequestMethod.GET)
	public String addProvider(@ModelAttribute("provider") SmbmsProvider provider,HttpSession session){
		return "provideradd";
	}
	//����id��ѯ����
	@RequestMapping(value="/pview/{id}")
	public String providerById(@PathVariable("id")Long id,Map<String, Object> model){
		SmbmsProvider provider = ps.getSmbmsProviderById(id);
		model.put("provider", provider);
		return "jsp/providerview";

	}
	//����id��ѯ��Ϣ
	@RequestMapping(value="modifyProvider.do")
	public String modifyProvider(@RequestParam("id") Long id,HttpSession session){
		SmbmsProvider provider = ps.getSmbmsProviderById(id);
		session.setAttribute("provider", provider);
		return "jsp/providermodify";
	}
	//�޸Ĺ�Ӧ��
	@RequestMapping(value="updateProvider.do")
	public String updateProvider(SmbmsProvider provider,HttpSession session){
		provider.setCreatedBy(((SmbmsUser)session.getAttribute("userSession")).getId());
		provider.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int result = ps.updateSmbmsProvider(provider);
		if (result >0) {
			return "redirect:/jsp/provider.do";
		}
		return "jsp/providermodify";
		
	}
	

	//���ļ��ϴ�
	/* @RequestMapping(value="providers.do")
	 public String providerSave(SmbmsProvider provider,MultipartFile photo,HttpSession session,HttpServletRequest request){

		 String path=request.getSession().getServletContext().getRealPath("photos");
		//���
		String error=getErrInfo(photo);
		//�ϴ�
		if (error==null) {
			String fileName=upload(photo, path);
			if (fileName != null) {
				provider.setPhotoPath("photos"+File.separator+fileName);
				provider.setCreatedBy(((SmbmsUser)session.getAttribute("userSession")).getId());
				 provider.setCreationDate(new Timestamp(System.currentTimeMillis()));
				 int result = ps.addSmbmsProvider(provider);
				 if (result>0) {
					 return "redirect:/jsp/provider.do";
				}
			}
			request.setAttribute("error", error);
		}

		return "providers.do";

	 }*/
	//���ļ��ϴ�
	@RequestMapping(value="providers.do")
	public String providerSave(SmbmsProvider provider,@RequestParam("photos") MultipartFile[] photos,HttpSession session,HttpServletRequest request){

		/*String path=request.getSession().getServletContext().getRealPath("photos");*/
		String path=request.getSession().getServletContext().getRealPath("photos");
		List<String> errors=new ArrayList<String>();
		/*	List<String> idPicPath=new ArrayList<String>();
			List<String> workPicPath=new ArrayList<String>();*/
		String error=null;
		String idPicPath=null;
		String workPicPath=null;
		String fileName=null;
		//���
		/*	for (MultipartFile photo : photos) {*/
		for (int i = 0; i < photos.length; i++) {
			MultipartFile photo=photos[i];
			error=getErrInfo(photo);
			//�ϴ�
			if (error ==null) {
				if (i==0) {
					fileName=upload(photo, path);
					idPicPath=fileName;
				}else if(i==1){
					fileName=upload(photo, path);
					workPicPath=fileName;

				}
			}else{
				errors.add(error);
			}


			if (i==0) {
				provider.setIdPicPath("photos"+File.separator+idPicPath);

			}else if(i==1){
				provider.setWorkPicPath("photos"+File.separator+workPicPath);
			}

		}

		provider.setCreatedBy(((SmbmsUser)session.getAttribute("userSession")).getId());
		provider.setCreationDate(new Timestamp(System.currentTimeMillis()));
		int result = ps.addSmbmsProvider(provider);
		if (result>0) {
			return "redirect:/jsp/provider.do";
		}

		request.setAttribute("error", error);
		request.setAttribute("idPicPath", idPicPath);
		request.setAttribute("workPicPath", workPicPath);
		return "providers.do";
	}


	public String upload(MultipartFile photos,String path){
		String fileName=photos.getOriginalFilename();
		long time=System.currentTimeMillis();
		int randNumber=RandomUtils.nextInt(1000000);
		File dest=new File(path,time+"_"+randNumber+"_"+fileName);
		fileName = time + "_" + randNumber + "_" + fileName;
		try {
			photos.transferTo(dest);
			return fileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//�ϴ��ļ���֤
	public String getErrInfo(MultipartFile photos){
		String error=null;
		//����ļ���
		String fileName=photos.getOriginalFilename();
		//��ȡ�ļ���׺
		String suf=FilenameUtils.getExtension(fileName);
		//�ж��Ƿ�Ϊ��
		if (photos.isEmpty()) {
			error=String.format("%s:�ϴ��ļ�����Ϊ��", fileName);
		}else if(photos.getSize()>5000000){  //�ж��ļ��Ĵ�С
			error=String.format("%s:�ϴ��ļ���С���ܳ���500kb", fileName);
		}else if(!formats.contains(suf.toLowerCase())){  //�ж��ļ���ʽ
			error=String.format("%s:�ϴ��ļ���ʽ����ȷ,֧�ֵĸ�ʽ:%s", fileName,formats);
		}
		return error;

	}
	static List<String> formats=new ArrayList<String>();
	static{
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}




}
