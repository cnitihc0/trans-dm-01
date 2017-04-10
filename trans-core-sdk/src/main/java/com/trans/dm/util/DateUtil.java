/**
 * 
 */
package com.trans.dm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author fengzp
 * @date 2015年4月14日
 */
public class DateUtil {

	static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);

	public static final String PATTERN_ALL = "yyyy-MM-dd HH:mm:ss";

	public static Date parseByyyyyMMddHHmmss(String source) {
		try {
			return new SimpleDateFormat("yyyyMMddHHmmss").parse(source);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage() + "[" + source + "]", e);

			return null;
		}
	}

	public static Date parseByyyyy_MM_ddHHmmss(String source) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage() + "[" + source + "]", e);

			return null;
		}
	}

	public static Date parse(String pattern, String source) {
		try {
			return new SimpleDateFormat(pattern).parse(source);
		} catch (ParseException e) {
			LOGGER.error(e.getMessage() + "[" + source + "]", e);

			return null;
		}
	}

	public static String toDateString(String pattern, Date date) {
		return new SimpleDateFormat(pattern).format(date);
	}

	public static String toDateStringWithyyyyMMddHHmmss(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}

	public static String toDateStringWithyyyy_MM_ddHHmmss(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	public static String toDateStringWithyyyyMMdd(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}

	public static String toDateStringWithyyyy_MM_dd(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static String toDateStringWithyyyyMM(Date date) {
		return new SimpleDateFormat("yyyyMM").format(date);
	}

	public static Calendar getTodayZero() {
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);
		return instance;
	}

	public static Calendar getDateZero(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);

		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);

		return instance;
	}

	/**
	 * 日期加天数
	 */
	public static Date addDay2Date(Date date, int days) {
		return DateUtil.addDate2Date(date, Calendar.DATE, days);
	}

	/**
	 * 日期加月数
	 */
	public static Date addMonth2Date(Date date, int months) {
		return DateUtil.addDate2Date(date, Calendar.MONTH, months);
	}

	/**
	 * 日期加日期
	 */
	public static Date addDate2Date(Date date, int field, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, num);
		return cal.getTime();
	}

	private static long nd = 1000 * 24 * 60 * 60;
	private static long nh = 1000 * 60 * 60;
	private static long nm = 1000 * 60;

	/**
	 * 计算2个日期相差多小天
	 * 
	 * @author fengzp
	 * @date 2015年3月2日
	 * @param smallDate
	 *            小的日期
	 * @param bigDate
	 *            大的日期
	 * @return
	 */
	public static int getDiffDays(Date smallDate, Date bigDate) {
		long diff = bigDate.getTime() - smallDate.getTime();
		return (int) (diff / nd);
	}

	/**
	 * 计算2个日期相差多小小时
	 * 
	 * @author fengzp
	 * @date 2015年3月2日
	 * @param smallDate
	 *            小的日期
	 * @param bigDate
	 *            大的日期
	 * @return
	 */
	public static int getDiffHours(Date smallDate, Date bigDate) {
		long diff = bigDate.getTime() - smallDate.getTime();
		return (int) (diff / nd * 24 + diff % nd / nh);
	}

	/**
	 * 计算2个日期相差多小分钟
	 * 
	 * @author fengzp
	 * @date 2015年3月2日
	 * @param smallDate
	 *            小的日期
	 * @param bigDate
	 *            大的日期
	 * @return
	 */
	public static int getDiffMinutes(Date smallDate, Date bigDate) {
		long diff = bigDate.getTime() - smallDate.getTime();
		return (int) (diff / nd * 1440 + diff % nd / nh * 60 + diff % nd % nh / nm);
	}
	
	public static int getWeekday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if(w == 0)
			return 7;
		return w;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.getWeekday(DateUtil.addDay2Date(new Date(), 0)));
	}
}
