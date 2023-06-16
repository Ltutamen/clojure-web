(ns hiccup-templating.views.contents
  (:use [hiccup.element :only [link-to]]
        [hiccup.form]))

(defn index []
  [:script {:src "https://code.jquery.com/jquery-3.6.0.min.js"}]
  [:script {:src "https://malsup.github.io/jquery.form.js"}]
  [:div {:id "content"}
   [:h1 {:class "text-success"} "Upload files"]
   [:form {:id "fileUploadForm" :action "/upload" :enctype "multipart/form-data"}
    [:label {:for "files"}]
    [:input {:type "file" :id "files" :multiple "multiple"}]
    [:input {:type "text" :id "tags"}]
    [:input {:type "submit" :formmethod "post"}]]])

(defn not-found []
  [:div
   [:h1 {:class "info-warning"} "Page Not Found"]
   [:p "There's no requested page. "]
   (link-to {:class "btn btn-primary"} "/" "Take me to Home")])