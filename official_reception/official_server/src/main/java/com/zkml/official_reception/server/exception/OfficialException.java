package com.zkml.official_reception.server.exception;

import com.zkml.common.obj.dto.ResultCode;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.exception.ServiceException;

/**
 * 公务接待服务的Exception
 */
public class OfficialException extends ServiceException {

    public OfficialException(long code, String message) {
        super(code, message);
    }

    public OfficialException(ResultModelDTO remoteResult) {
        super(remoteResult);
    }

    public OfficialException(ResultCode resultCode) {
        super(resultCode);
    }
}
