package com.backbase.api.acl.request;

import com.backbase.api.common.request.IRequestType;

public enum EnumAclRequestType implements IRequestType {
  ACL_REQUEST_GET_ACCOUNT,
  ACL_REQUEST_UPDATE_ACCOUNT,
  ACL_REQUEST_CREATE_ACCOUNT,
  ACL_REQUEST_DELETE_ACCOUNT,
  ACL_REQUEST_GET_TRANSACTION,
  ACL_REQUEST_CREATE_TRANSACTION,
}
