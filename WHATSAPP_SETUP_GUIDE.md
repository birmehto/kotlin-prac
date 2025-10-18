# Free WhatsApp Messaging Setup Guide

## 🚀 Best Free Options (Ranked by Reliability)

### 1. **Maytapi** (Recommended) - 1000 free messages/month
- **Setup**: Sign up at https://maytapi.com
- **Secrets needed**:
  - `MAYTAPI_PRODUCT_ID`
  - `MAYTAPI_PHONE_ID` 
  - `MAYTAPI_API_TOKEN`
- **Pros**: Most reliable, good free tier
- **File**: `.github/workflows/whatsapp-maytapi.yml`

### 2. **Twilio Sandbox** - Free with verification
- **Setup**: Sign up at https://twilio.com
- **Secrets needed**:
  - `TWILIO_ACCOUNT_SID`
  - `TWILIO_AUTH_TOKEN`
- **Note**: Your number must be verified in Twilio sandbox
- **File**: `.github/workflows/whatsapp-twilio.yml`

### 3. **UltraMsg** - 7 days free trial
- **Setup**: Sign up at https://ultramsg.com
- **Secrets needed**:
  - `ULTRAMSG_INSTANCE_ID`
  - `ULTRAMSG_TOKEN`
- **File**: `.github/workflows/daily-whatsapp.yml`

### 4. **Green-API** - Free tier available
- **Setup**: Sign up at https://green-api.com
- **Secrets needed**:
  - `GREEN_API_INSTANCE_ID`
  - `GREEN_API_TOKEN`
- **File**: `.github/workflows/daily-whatsapp.yml`

### 5. **WATI** - Free tier with limitations
- **Setup**: Sign up at https://wati.io
- **Secrets needed**:
  - `WATI_API_KEY`
- **File**: `.github/workflows/daily-whatsapp.yml`

## 🔧 How to Add GitHub Secrets

1. Go to your GitHub repository
2. Click **Settings** → **Secrets and variables** → **Actions**
3. Click **New repository secret**
4. Add the required secrets for your chosen service

## 📱 Your Phone Number
All workflows are configured for: **+917528940605**

## ⏰ Schedule
All workflows run at **10:00 AM IST** (4:30 UTC) daily

## 🎯 Quick Start (Recommended: Maytapi)

1. Sign up at https://maytapi.com
2. Get your credentials
3. Add secrets to GitHub:
   - `MAYTAPI_PRODUCT_ID`
   - `MAYTAPI_PHONE_ID`
   - `MAYTAPI_API_TOKEN`
4. Enable `.github/workflows/whatsapp-maytapi.yml`
5. Test with "Run workflow" button

## 🔄 Fallback Strategy
The main workflow tries multiple services in order, so if one fails, it tries the next one automatically.

## 🆓 Completely Free Alternatives
If WhatsApp APIs don't work, consider:
- **Telegram Bot** (unlimited free messages)
- **Email notifications** (via Gmail SMTP)
- **Discord webhooks** (unlimited free)

Choose the service that works best for you!