<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/23
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
    <h4 class="modal-title">审核材料</h4>
</div>
<div class="modal-body">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-5 pull-left">
                    <img src="${aptitude.IDCardImgZ}" class="col-md-12">
                    <label>身份证正面</label>
                </div>
                <div class="col-md-5 pull-right">
                    <img src="${aptitude.IDCardImgF}" class="col-md-12">
                    <label>身份证反面</label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5 pull-left">
                    <img src="${aptitude.shopImg}" class="col-md-12">
                    <label>店铺照片</label>
                </div>
                <div class="col-md-5 pull-right">
                    <img src="${aptitude.businessLicenseImg}" class="col-md-12">
                    <label>营业执照</label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5 pull-left img-responsive">
                    <img src="${aptitude.foodLicense}" class="col-md-12">
                    <label>视频许可证</label>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal-footer">
    <button type="button" class="btn default" data-dismiss="modal">关闭</button>
</div>
