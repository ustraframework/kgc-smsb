package kr.co.kgc.smsb.bo.config;

import com.gsitm.ustra.java.core.process.ProcessInfoUtils;
import com.gsitm.ustra.java.core.utils.UstraStringUtils;
import com.gsitm.ustra.java.data.logging.query.QueryLogWriter;
import com.gsitm.ustra.java.data.mybatis.proxy.MapperManager;
import com.gsitm.ustra.java.management.models.UstraSysDbmsQryHistModel;
import kr.co.kgc.smsb.bo.sample.repository.SysDbmsQryHistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * management 공통 Query writer
 *
 * @author keyma
 */
@Slf4j
@Component
public class UstraManagementQueryLogWriter implements QueryLogWriter {

    @Autowired
    @Qualifier("loggingThreadPoolTaskScheduler")
    private ThreadPoolTaskScheduler loggingThreadPoolTaskScheduler;



    @Override
    public boolean support(String statementId) {
        // framework 관련 repository 제외
//        if (UstraStringUtils.matchWildCard(statementId, "com.gsitm.ustra.java.management.repositories.UstraMenuRepository.*")) {
//            return true;
//        }
        // 시퀀스 조회 쿼리 제외
        if (UstraStringUtils.matchWildCard(statementId, "com.gsitm.ustra.java.management.repositories.*.selectKey")) {
            return false;
        }

        // 토큰 관련 쿼리 제외
        if (UstraStringUtils.matchWildCard(statementId, "com.gsitm.ustra.java.management.repositories.UstraRefreshTokenRepository.*")) {
            return false;
        }

        // 쿼리 로깅 제외
        if (UstraStringUtils.matchWildCard(statementId, "kr.co.kgc.smsb.bo.sample.repository.SysDbmsQryHistRepository.*")) {
            return false;
        }

        // 메뉴 access history 제외
        if (UstraStringUtils.matchWildCard(statementId, "com.gsitm.ustra.java.management.repositories.UstraMenuAccessHistoryRepository.*")) {
            return false;
        }

        return true;
    }

    @Override
    public void writeLog(String statementId, String orgCont, String execCont, long ms) {

//        int historyId = MapperManager.get(SysDbmsQryHistRepository.class).selectKey();
        final UstraSysDbmsQryHistModel historyData =
                UstraSysDbmsQryHistModel
                        .builder()
                        .procId(ProcessInfoUtils.getCurrentProcessId())
                        .reqId(ProcessInfoUtils.getCurrentRequestId())
//                        .dbmsQryHistId(historyId)
                        .orgQryCont(orgCont)
                        .execQryCont(execCont)
                        .procMs("" + ms)
                        .build();

        // 데이터 입력은 별도 Thread 에서 처리
        CompletableFuture
                .completedFuture(this.loggingThreadPoolTaskScheduler)
                .thenAcceptAsync(v -> MapperManager.get(SysDbmsQryHistRepository.class).insert(historyData));
    }

//	@Override
//	public boolean support(String statementId) {
//
//		// framework 관련 repository 제외
////		if (UstraStringUtils.matchWildCard(statementId, "com.gsitm.ustra.java.management.repositories.*")) {
////			return false;
////		}
//
//        if (UstraStringUtils.matchWildCard(statementId, "com.gsitm.ustra.java.management.repositories.UstraRefreshTokenRepository.*")) {
//            return false;
//        }
//
//		return true;
//	}
//
//	@Override
//	public void writeLog(String statementId, String orgCont, String execCont, long ms) {
//		UstraTransactionUtils.<Void, Void>execute((p)->{
//
//			try {
//				int historyId = MapperManager.get(UstraSysDbmsQryHistRepository.class).selectKey();
//				final UstraSysDbmsQryHistModel historyData =
//						UstraSysDbmsQryHistModel
//							.builder()
//							.procId(ProcessInfoUtils.getCurrentProcessId())
//							.reqId(ProcessInfoUtils.getCurrentRequestId())
//							.dbmsQryHistId(historyId)
//							.orgQryCont(orgCont)
//							.execQryCont(execCont)
//							.procMs("" + ms)
//							.build();
//				MapperManager.get(UstraSysDbmsQryHistRepository.class).insert(historyData);
//			} catch (Exception e) {
//				log.error(e.getMessage(), e);
//			}
//
//			return null;
//		}, null, UstraTransactionUtils.TransactionExecuteOption.withFrameworkDataSource());
//	}

}
