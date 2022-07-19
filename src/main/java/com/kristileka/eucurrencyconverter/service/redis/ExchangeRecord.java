package com.kristileka.eucurrencyconverter.service.redis;

import com.opencsv.bean.CsvDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@RedisHash("DailyRecord")
public class ExchangeRecord implements Serializable {
    public ExchangeRecord() {
    }

    @Id
    @CsvDate(value = "yyyy-MM-dd")
    LocalDate Date;
    String USD;
    String JPY;
    String BGN;
    String CYP;
    String CZK;
    String DKK;
    String EEK;
    String GBP;
    String HUF;
    String LTL;
    String LVL;
    String MTL;
    String PLN;
    String ROL;
    String RON;
    String SEK;
    String SIT;
    String SKK;
    String CHF;
    String ISK;
    String NOK;
    String HRK;
    String RUB;
    String TRL;
    String TRY;
    String AUD;
    String BRL;
    String CAD;
    String CNY;
    String HKD;
    String IDR;
    String ILS;
    String INR;
    String KRW;
    String MXN;
    String MYR;
    String NZD;
    String PHP;
    String SGD;
    String THB;
    String ZAR;

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate localDate) {
        Date = localDate;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }

    public String getJPY() {
        return JPY;
    }

    public void setJPY(String JPY) {
        this.JPY = JPY;
    }

    public String getBGN() {
        return BGN;
    }

    public void setBGN(String BGN) {
        this.BGN = BGN;
    }

    public String getCYP() {
        return CYP;
    }

    public void setCYP(String CYP) {
        this.CYP = CYP;
    }

    public String getCZK() {
        return CZK;
    }

    public void setCZK(String CZK) {
        this.CZK = CZK;
    }

    public String getDKK() {
        return DKK;
    }

    public void setDKK(String DKK) {
        this.DKK = DKK;
    }

    public String getEEK() {
        return EEK;
    }

    public void setEEK(String EEK) {
        this.EEK = EEK;
    }

    public String getGBP() {
        return GBP;
    }

    public void setGBP(String GBP) {
        this.GBP = GBP;
    }

    public String getHUF() {
        return HUF;
    }

    public void setHUF(String HUF) {
        this.HUF = HUF;
    }

    public String getLTL() {
        return LTL;
    }

    public void setLTL(String LTL) {
        this.LTL = LTL;
    }

    public String getLVL() {
        return LVL;
    }

    public void setLVL(String LVL) {
        this.LVL = LVL;
    }

    public String getMTL() {
        return MTL;
    }

    public void setMTL(String MTL) {
        this.MTL = MTL;
    }

    public String getPLN() {
        return PLN;
    }

    public void setPLN(String PLN) {
        this.PLN = PLN;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String ROL) {
        this.ROL = ROL;
    }

    public String getRON() {
        return RON;
    }

    public void setRON(String RON) {
        this.RON = RON;
    }

    public String getSEK() {
        return SEK;
    }

    public void setSEK(String SEK) {
        this.SEK = SEK;
    }

    public String getSIT() {
        return SIT;
    }

    public void setSIT(String SIT) {
        this.SIT = SIT;
    }

    public String getSKK() {
        return SKK;
    }

    public void setSKK(String SKK) {
        this.SKK = SKK;
    }

    public String getCHF() {
        return CHF;
    }

    public void setCHF(String CHF) {
        this.CHF = CHF;
    }

    public String getISK() {
        return ISK;
    }

    public void setISK(String ISK) {
        this.ISK = ISK;
    }

    public String getNOK() {
        return NOK;
    }

    public void setNOK(String NOK) {
        this.NOK = NOK;
    }

    public String getHRK() {
        return HRK;
    }

    public void setHRK(String HRK) {
        this.HRK = HRK;
    }

    public String getRUB() {
        return RUB;
    }

    public void setRUB(String RUB) {
        this.RUB = RUB;
    }

    public String getTRL() {
        return TRL;
    }

    public void setTRL(String TRL) {
        this.TRL = TRL;
    }

    public String getTRY() {
        return TRY;
    }

    public void setTRY(String TRY) {
        this.TRY = TRY;
    }

    public String getAUD() {
        return AUD;
    }

    public void setAUD(String AUD) {
        this.AUD = AUD;
    }

    public String getBRL() {
        return BRL;
    }

    public void setBRL(String BRL) {
        this.BRL = BRL;
    }

    public String getCAD() {
        return CAD;
    }

    public void setCAD(String CAD) {
        this.CAD = CAD;
    }

    public String getCNY() {
        return CNY;
    }

    public void setCNY(String CNY) {
        this.CNY = CNY;
    }

    public String getHKD() {
        return HKD;
    }

    public void setHKD(String HKD) {
        this.HKD = HKD;
    }

    public String getIDR() {
        return IDR;
    }

    public void setIDR(String IDR) {
        this.IDR = IDR;
    }

    public String getILS() {
        return ILS;
    }

    public void setILS(String ILS) {
        this.ILS = ILS;
    }

    public String getINR() {
        return INR;
    }

    public void setINR(String INR) {
        this.INR = INR;
    }

    public String getKRW() {
        return KRW;
    }

    public void setKRW(String KRW) {
        this.KRW = KRW;
    }

    public String getMXN() {
        return MXN;
    }

    public void setMXN(String MXN) {
        this.MXN = MXN;
    }

    public String getMYR() {
        return MYR;
    }

    public void setMYR(String MYR) {
        this.MYR = MYR;
    }

    public String getNZD() {
        return NZD;
    }

    public void setNZD(String NZD) {
        this.NZD = NZD;
    }

    public String getPHP() {
        return PHP;
    }

    public void setPHP(String PHP) {
        this.PHP = PHP;
    }

    public String getSGD() {
        return SGD;
    }

    public void setSGD(String SGD) {
        this.SGD = SGD;
    }

    public String getTHB() {
        return THB;
    }

    public void setTHB(String THB) {
        this.THB = THB;
    }

    public String getZAR() {
        return ZAR;
    }

    public void setZAR(String ZAR) {
        this.ZAR = ZAR;
    }
}
