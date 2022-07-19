package com.kristileka.eucurrencyconverter.service.redis;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@RedisHash("DailyRecord")
public class ExchangeRecord implements Serializable {
    public ExchangeRecord() {
    }

    @Id
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(column = "Date")
    Date date;
    @CsvBindByName(column = "USD")
    String usd;
    @CsvBindByName(column = "JPY")
    String jpy;
    @CsvBindByName(column = "BGN")
    String bgn;
    @CsvBindByName(column = "CYP")
    String cyp;
    @CsvBindByName(column = "CZK")
    String czk;
    @CsvBindByName(column = "DKK")
    String dkk;
    @CsvBindByName(column = "EEK")
    String eek;
    @CsvBindByName(column = "GBP")
    String gbp;
    @CsvBindByName(column = "HUF")
    String huf;
    @CsvBindByName(column = "LTL")
    String ltl;
    @CsvBindByName(column = "LVL")
    String lvl;
    @CsvBindByName(column = "MTL")
    String mtl;
    @CsvBindByName(column = "PLN")
    String pln;
    @CsvBindByName(column = "ROL")
    String rol;
    @CsvBindByName(column = "RON")
    String ron;
    @CsvBindByName(column = "SEK")
    String sek;
    @CsvBindByName(column = "SIT")
    String sit;
    @CsvBindByName(column = "SKK")
    String skk;
    @CsvBindByName(column = "CHF")
    String chf;
    @CsvBindByName(column = "ISK")
    String isk;
    @CsvBindByName(column = "NOK")
    String nok;
    @CsvBindByName(column = "HRK")
    String hrk;
    @CsvBindByName(column = "RUB")
    String rub;
    @CsvBindByName(column = "TRL")
    String trl;
    @CsvBindByName(column = "TRY")
    String tr;
    @CsvBindByName(column = "AUD")
    String aud;
    @CsvBindByName(column = "BRL")
    String brl;
    @CsvBindByName(column = "CAD")
    String cad;
    @CsvBindByName(column = "CNY")
    String cny;
    @CsvBindByName(column = "HKD")
    String hkd;
    @CsvBindByName(column = "IDR")
    String idr;
    @CsvBindByName(column = "ILS")
    String ils;
    @CsvBindByName(column = "INR")
    String inr;
    @CsvBindByName(column = "KRW")
    String krw;
    @CsvBindByName(column = "MXN")
    String mxn;
    @CsvBindByName(column = "MYR")
    String myr;
    @CsvBindByName(column = "NZD")
    String nzd;
    @CsvBindByName(column = "PHP")
    String php;
    @CsvBindByName(column = "SGD")
    String sgd;
    @CsvBindByName(column = "THB")
    String thb;
    @CsvBindByName(column = "ZAR")
    String zar;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getJpy() {
        return jpy;
    }

    public void setJpy(String jpy) {
        this.jpy = jpy;
    }

    public String getBgn() {
        return bgn;
    }

    public void setBgn(String bgn) {
        this.bgn = bgn;
    }

    public String getCyp() {
        return cyp;
    }

    public void setCyp(String cyp) {
        this.cyp = cyp;
    }

    public String getCzk() {
        return czk;
    }

    public void setCzk(String czk) {
        this.czk = czk;
    }

    public String getDkk() {
        return dkk;
    }

    public void setDkk(String dkk) {
        this.dkk = dkk;
    }

    public String getEek() {
        return eek;
    }

    public void setEek(String eek) {
        this.eek = eek;
    }

    public String getGbp() {
        return gbp;
    }

    public void setGbp(String gbp) {
        this.gbp = gbp;
    }

    public String getHuf() {
        return huf;
    }

    public void setHuf(String huf) {
        this.huf = huf;
    }

    public String getLtl() {
        return ltl;
    }

    public void setLtl(String ltl) {
        this.ltl = ltl;
    }

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public String getMtl() {
        return mtl;
    }

    public void setMtl(String mtl) {
        this.mtl = mtl;
    }

    public String getPln() {
        return pln;
    }

    public void setPln(String pln) {
        this.pln = pln;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRon() {
        return ron;
    }

    public void setRon(String ron) {
        this.ron = ron;
    }

    public String getSek() {
        return sek;
    }

    public void setSek(String sek) {
        this.sek = sek;
    }

    public String getSit() {
        return sit;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }

    public String getSkk() {
        return skk;
    }

    public void setSkk(String skk) {
        this.skk = skk;
    }

    public String getChf() {
        return chf;
    }

    public void setChf(String chf) {
        this.chf = chf;
    }

    public String getIsk() {
        return isk;
    }

    public void setIsk(String isk) {
        this.isk = isk;
    }

    public String getNok() {
        return nok;
    }

    public void setNok(String nok) {
        this.nok = nok;
    }

    public String getHrk() {
        return hrk;
    }

    public void setHrk(String hrk) {
        this.hrk = hrk;
    }

    public String getRub() {
        return rub;
    }

    public void setRub(String rub) {
        this.rub = rub;
    }

    public String getTrl() {
        return trl;
    }

    public void setTrl(String trl) {
        this.trl = trl;
    }

    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    public String getBrl() {
        return brl;
    }

    public void setBrl(String brl) {
        this.brl = brl;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }

    public String getCny() {
        return cny;
    }

    public void setCny(String cny) {
        this.cny = cny;
    }

    public String getHkd() {
        return hkd;
    }

    public void setHkd(String hkd) {
        this.hkd = hkd;
    }

    public String getIdr() {
        return idr;
    }

    public void setIdr(String idr) {
        this.idr = idr;
    }

    public String getIls() {
        return ils;
    }

    public void setIls(String ils) {
        this.ils = ils;
    }

    public String getInr() {
        return inr;
    }

    public void setInr(String inr) {
        this.inr = inr;
    }

    public String getKrw() {
        return krw;
    }

    public void setKrw(String krw) {
        this.krw = krw;
    }

    public String getMxn() {
        return mxn;
    }

    public void setMxn(String mxn) {
        this.mxn = mxn;
    }

    public String getMyr() {
        return myr;
    }

    public void setMyr(String myr) {
        this.myr = myr;
    }

    public String getNzd() {
        return nzd;
    }

    public void setNzd(String nzd) {
        this.nzd = nzd;
    }

    public String getPhp() {
        return php;
    }

    public void setPhp(String php) {
        this.php = php;
    }

    public String getSgd() {
        return sgd;
    }

    public void setSgd(String sgd) {
        this.sgd = sgd;
    }

    public String getThb() {
        return thb;
    }

    public void setThb(String thb) {
        this.thb = thb;
    }

    public String getZar() {
        return zar;
    }

    public void setZar(String zar) {
        this.zar = zar;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }
}
