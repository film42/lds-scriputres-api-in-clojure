(ns lds-scriptures-api.views.volume
  (:require [lds-scriptures-api.db :as db]))

(defn template [v books]
  {:title      (v :volume_title)
   :title_long (v :volume_title_long)
   :subtitle   (v :volume_subtitle)
   :slug       (v :lds_org)
   :chapters   (v :num_chapters)
   :verses     (v :num_verses)})

(defn render [volume]
  (let [v (db/get-volume volume)]
    (if (nil? v)
      ;; Not found
      {:error "Not found"}
      ;; Render
      (template v nil))))