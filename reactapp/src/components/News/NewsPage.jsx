import { React, useState, useEffect } from "react";
import AuthService from "../services/AuthService";
import NewsService from "../services/NewsService";
import NewsList from "./NewsList";
import Slider from "../Slider/Slider";
import NewsTable from "./NewsTable";
import NotFound from "../PageNotFound";

function NewsPage() {
  const [news, setNews] = useState(null);

  useEffect(() => {
    NewsService.getNews().then((response) => {
      console.log(response.data);
      setNews(response.data);
    });
  }, []);

  if (news === null) {
    return <NotFound></NotFound>;
  } else if (news !== null) {
    return (
      <div>
        {AuthService.getCurrentUser() !== null &&
          AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
            <>
              <div
                style={{
                  display: "flex",
                  marginTop: "10px",
                  justifyContent: "center",
                  alignItems: "top",
                  height: "10vh",
                }}
              >
                <h1>News</h1>
              </div>
              <div className="container">
                <NewsTable></NewsTable>
              </div>
            </>
          )}

        {AuthService.getCurrentUser() === null && (
          <>
            <Slider />
            <br />
            <div className="container">
              <h1>News</h1>
              <br />
              <NewsList news={news} />
            </div>
          </>
        )}

        {AuthService.getCurrentUser() !== null &&
          AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
            <>
              <Slider />
              <br />
              <div className="container">
                <h1>News</h1>
                <br />
                <NewsList news={news} />
              </div>
            </>
          )}
      </div>
    );
  }
}

export default NewsPage;
