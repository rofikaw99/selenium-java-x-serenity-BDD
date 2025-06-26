console.log("📢 Starting login script...");

const { chromium } = require('playwright');

(async () => {
  console.log("🚀 Launching browser...");
  const browser = await chromium.launch({ headless: false });

  const context = await browser.newContext({
    httpCredentials: {
      username: 'admin',
      password: 'admin@ccnhub'
    }
  });

  const page = await context.newPage();
  console.log("🌐 Navigating to login-protected page...");
  await page.goto('https://sandbox.cubeforall.com/');

  console.log("🔎 Waiting for sign in page appear to appear...");
  try {
    await page.waitForSelector('button.login-btn', { timeout: 7000 });
    console.log("✅ Login success — saving session state...");
    await context.storageState({ path: 'state.json' });
  } catch (error) {
    console.error("❌ Login failed or selector not found:", error.message);
  }

  await browser.close();
  console.log("🏁 Success pass the auth");
})();